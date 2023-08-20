from flask_app import app
from flask import Flask, session, render_template, request, redirect, flash
from flask_app.models.user import User
from flask_app.models.arbortrary import Arbortrary
from flask_app.controllers import arbortrary

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

@app.route("/")
def user_login():
    return render_template("login.html")

@app.route("/register/user", methods=["POST"])
def register():
    if not User.validate_registration(request.form):
        return redirect("/")
    # create the hash
    pw_hash = bcrypt.generate_password_hash(request.form['password'])
    print(pw_hash)
    # put the pw_hash into the data dictionary
    data = {
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email'],
        "password" : pw_hash
    }
    # Call the save @classmethod on User
    user_id = User.add_user(data)
    # store user id into session
    session['user_id'] = user_id
    return redirect("/dashboard")

@app.route("/login/user", methods=["POST"])
def login():
    data = { "email" : request.form["email"] }
    user_in_db = User.get_one_by_email(data)
    if not user_in_db:
        flash("Invalid Email/Password")
        return redirect("/")
    if not bcrypt.check_password_hash(user_in_db.password, request.form['password']):
        flash("Invalid Email/Password")
        return redirect('/')
    session['user_id'] = user_in_db.id
    return redirect("/dashboard")

@app.route("/user/account")
def user_tree():
    if "user_id" not in session:
        return redirect("/")
    user = User.get_one_by_id({"id":session["user_id"]})
    if not user:
        return redirect("/")
    print(user)
    return render_template("user_tree.html", user=user, arbortraries_of_user=User.get_user_with_arbortrary({"id": id}))

@app.route("/logout")
def logoout():
    session.clear()
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)