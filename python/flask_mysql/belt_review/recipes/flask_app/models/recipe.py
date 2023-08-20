from flask_app.config.mysqlconnection import connectToMySQL

import re	# the regex module
# create a regular expression object that we'll use later   
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

from flask import flash
from flask_app.models import user

class Recipe:
    
    db_name = "recipes_schema"
    
    def __init__( self , data ):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.instructions = data['instructions']
        self.date_cooked = data['date_cooked']
        self.under_30 = data['under_30']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user = None
    
    @classmethod
    def add_recipe(cls,data):
        query = """INSERT INTO recipes (name,description,instructions,date_made,under_30,user_id)
                VALUES (%(name)s,%(description)s,%(instructions)s,%(date_made)s,%(under_30)s,%(user_id)s);"""
        return connectToMySQL(cls.db_name).query_db(query,data)
    
    @classmethod
    def get_all(cls):
        query = """SELECT * FROM recipes JOIN users on recipes.user_id = users.id;"""
        results = connectToMySQL(cls.db_name).query_db(query)
        recipes = []
        for recipes in results:
            recipe = cls(recipes)
            data = {
                "id": recipes['users.id'],
                "first_name": recipes['first_name'],
                "last_name": recipes['last_name'],
                "email": recipes['email'],
                "password": "",
                "created_at": recipes['users.created_at'],
                "updated_at": recipes['users.updated_at']
            }
            recipe.user = user.User(data)
            recipes.append(recipe)
        return recipes
    
    @classmethod
    def get_one_by_id(cls,data):
        query = """SELECT * FROM recipes JOIN users on recipes.user_id = users.id 
                WHERE recipes.id = %(id)s;"""
        results = connectToMySQL(cls.db_name).query_db(query,data)
        if not results:
            return False
        result = results[0]
        recipe = cls(result)
        data = {
                "id": result['users.id'],
                "first_name": result['first_name'],
                "last_name": result['last_name'],
                "email": result['email'],
                "password": "",
                "created_at": result['users.created_at'],
                "updated_at": result['users.updated_at']
        }
        recipe.user = user.User(data)
        return recipe

    @classmethod
    def update(cls,data):
        query = """UPDATE recipes
                SET name = %(name)s,
                description = %(description)s,
                instructions = %(instructions)s ,
                date_made = %(date_made)s,
                under_30 = %(under_30)s
                WHERE id = %(id)s;
                """
        return connectToMySQL(cls.db_name).query_db(query,data)
    
    @classmethod
    def remove(cls,data):
        query = """DELETE FROM recipes WHERE id = %(id)s;"""
        return connectToMySQL(cls.db_name).query_db(query,data)
    
    @staticmethod
    def validate_recipe(data):
        is_valid = True
        if len(data['name']) < 3:
            flash("Name must be at least 3 characters.")
            is_valid = False
        if len(data['description']) < 3:
            flash("Description must be at least 3 characters.")
            is_valid = False
        if len(data['instructions']) < 3:
            flash("Instructions must be at least 3 characters.")
            is_valid = False
        if data['date_made'] == '':
            flash("Date is missing.")
            is_valid = False
        if 'under_30' not in data:
            flash("Cook time is missing.")
            is_valid = False
        return is_valid