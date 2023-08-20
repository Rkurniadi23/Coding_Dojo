from flask import Flask, session, render_template, request, redirect

import dojo, ninja

app = Flask(__name__)

@app.route("/ninjas")
def ninjas():
    return render_template("ninjas.html", all_dojos = dojo.Dojos.get_all_dojos())

@app.route("/ninjas/add_to_db", methods=["POST"])
def ninjas_post():
    ninja.Ninjas.add_ninja(request.form)
    return redirect("/dojos")

@app.route("/dojos")
def dojos():
    return render_template("dojos.html", all_dojos = dojo.Dojos.get_all_dojos())

@app.route("/dojos/add_to_db", methods=["POST"])
def dojos_post():
    dojo.Dojos.add_dojo(request.form)
    return redirect("/dojos")

@app.route("/dojos/<int:id>")
def show_dojo(id):
    database = {
        "id" : id
    }
    this_dojo = dojo.Dojos.get_ninjas(database)
    return render_template("show_dojos.html", this_dojo = this_dojo)

if __name__ == "__main__":
    app.run(debug=True)

