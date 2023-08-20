from flask_app import app
from flask import Flask, session, render_template, request, redirect, flash
from flask_app.models.user import User
from flask_app.models.arbortrary import Arbortrary
from flask_app.controllers import users

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)


@app.route("/dashboard")
def dashboard():
    if "user_id" not in session:
        return redirect("/")
    user = User.get_one_by_id({"id":session["user_id"]})
    if not user:
        return redirect("/logoff")
    return render_template("dashboard.html", user=user, arbortraries=Arbortrary.get_all())

@app.route("/new/tree")
def create_tree():
    if "user_id" not in session:
        return redirect("/user/login")

    return render_template("new_tree.html")

@app.route("/arbirtrary/new/tree", methods=["POST"])
def add_tree():
    if "user_id" not in session:
        return redirect("/")
    if not Arbortrary.validate_arbortrary(request.form):
        return redirect("/new/tree")

    data = {
        "user_id": session["user_id"],
        "species": request.form["species"],
        "location": request.form["location"],
        "reason": request.form["reason"],
        "planted_date": request.form["planted_date"],
    }
    Arbortrary.add_arbortrary(data)
    return redirect("/dashboard")

@app.route("/edit/<int:id>")
def edit_arbortrary(id):
    if "user_id" not in session:
        return redirect("/user/login")
    return render_template("edit.html",arbortrary=Arbortrary.get_one_by_id({"id": id}))

@app.route("/replant/tree/<int:id>", methods=["POST"])
def replant_tree(id):
    if "user_id" not in session:
        return redirect("")
    if not Arbortrary.validate_arbortrary(request.form):
        return redirect("/")
    data = {
        "id": id,
        "species": request.form["species"],
        "location": request.form["location"],
        "reason": request.form["reason"],
        "planted_date": request.form["planted_date"],
    }
    Arbortrary.update(data)
    return redirect("/user/account")

@app.route('/show/<int:id>')
def show_arbortrary(id):
    if 'user_id' not in session:
        return redirect('/user/login')
    user = User.get_one_by_id({"id":session["user_id"]})
    return render_template('show.html',user=user,arbortrary=Arbortrary.get_one_by_id({'id': id}))

@app.route("/delete/<int:id>")
def destroy_recipe(id):
    if "user_id" not in session:
        return redirect("/")
    Arbortrary.remove({"id":id})
    return redirect("/user/tree")