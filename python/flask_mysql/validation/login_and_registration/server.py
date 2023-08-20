from flask import Flask, session, render_template, request, redirect

from flask_app import app
from flask_app.controllers import users

if __name__ == "__main__":
    app.run(debug=True)

