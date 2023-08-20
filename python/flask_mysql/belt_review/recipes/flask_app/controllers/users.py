from flask_app import app
from flask import Flask, session, render_template, request, redirect, flash
from flask_app.models.user import User


from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

@app.route("/")
def dashboard():
    return render_template("dashboard.html")

@app.route("/register/user", methods=["POST"])
def register_post():
    if not User.validate_user(request.form):
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
    id = User.add_user(data)
    # store user id into session
    session['user_id'] = id
    return redirect("/recipes")

@app.route("/login/user", methods=["POST"])
def login_post():
    user = User.get_email(request.form)
    if not user:
        flash("Invalid Email.", "login")
        return redirect("/register")
    if not bcrypt.check_password_hash(user.password, request.form['password']):
        flash("Invalid Password", "login")
        return redirect("/register")
    session['user_id'] = user.id
    return redirect("/recipes")

@app.route("/recipes")
def show():
    if "user_id" not in session:
        return redirect("/logoff")
    data={
        "id": session["user_id"]
    }
    return render_template("recipes.html", users=User.get_one(data))



@app.route("/reg")
def reg():
    if "user_id" not in session:
        return redirect("/logoff")
    data={
        "id": session["user_id"]
    }
    return render_template(".html", users=User.get_one(data))

@app.route("/logoff")
def logoff():
    session.clear()
    return redirect("/register")

if __name__ == "__main__":
    app.run(debug=True)