from flask_app.config.mysqlconnection import connectToMySQL

import re	# the regex module
# create a regular expression object that we'll use later   
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

from flask import flash

class User:
    
    db_name = "login_and_registration_schema"
    
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    
    @classmethod
    def add_user(cls,data):
        query = """INSERT INTO users (first_name, last_name, email, password, created_at, updated_at) 
        VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s, NOW(), NOW());"""
        results = connectToMySQL(cls.db_name).query_db(query,data)  
        return results
    
    @classmethod
    def get_one(cls,data):
        query = """SELECT * from users WHERE id = %(id)s;"""
        results = connectToMySQL(cls.db_name).query_db(query,data) 
        users = []
        # Iterate over the db results and create instances of friends with cls.
        for user in results:
            users.append(cls(user))
        return users
    
    @classmethod
    def get_email(cls,data):
        query = """SELECT * from users WHERE email = %(email)s;"""
        results = connectToMySQL(cls.db_name).query_db(query,data) 
        if len(results) < 1:
            return False
        user = cls(results[0])
        return user

    @staticmethod
    def validate_user(user):
        query = """SELECT * from users WHERE email = %(email)s;"""
        results = connectToMySQL(User.db_name).query_db(query,user)
        is_valid = True # we assume this is true
        if len(user['first_name']) < 3:
            flash("First Name must be at least 3 characters.", "register")
            is_valid = False
        if len(user['last_name']) < 3:
            flash("Last Name must be at least 3 characters.", "register")
            is_valid = False
        if len(user['password']) < 8:
            flash("Password must be at least 8 characters.", "register")
            is_valid = False
        if user['password'] != user['confirm_password']:
            flash("Password doesn't match.", "register")
        if not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!", "register")
            is_valid = False
        if len(results) >= 1:
            flash("Email has been taken.", "register")
            is_valid = False
        return is_valid
