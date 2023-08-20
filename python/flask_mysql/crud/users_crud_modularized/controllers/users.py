from flask import Flask, render_template, request, redirect

from users_crud_modularized import app

from users_crud_modularized.models.user import Users

app = Flask(__name__)

@app.route("/")
def index():
    return redirect("/users")

@app.route("/users")
def users():
    return render_template("index.html", users=Users.get_all())

@app.route("/users/new")
def new_users():
    return render_template("new_users.html")

@app.route("/users/post", methods=["POST"])
def post():
    print(request.form)
    Users.storage(request.form)
    return redirect("/users/edit/{{ user.id }}")

@app.route("/users/<int:num>")
def show(num):
    data ={
        "id":num
    }
    return render_template("show.html", users=Users.get_one(data))

@app.route("/users/delete/<int:num>")
def delete(num):
    data ={
        "id":num
    }
    Users.delete(data)
    return redirect("/users")

@app.route("/users/edit/<int:num>")
def edit(num):
    data ={
        "id":num
    }
    return render_template("edit.html", users=Users.get_one(data))
            
if __name__ == "__main__":
    app.run(debug=True)

