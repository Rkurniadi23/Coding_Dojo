from flask import Flask, render_template, request, redirect

from users import Users

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
    return redirect("/users")
            
if __name__ == "__main__":
    app.run(debug=True)

