from flask_app.config.mysqlconnection import connectToMySQL

import re	# the regex module
# create a regular expression object that we'll use later   
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

from flask import flash
from flask_app.models import user

class Arbortrary:
    
    db_name = "arbortrary_schema"
    
    def __init__( self , data ):
        self.id = data['id']
        self.species = data['species']
        self.location = data['location']
        self.reason = data['reason']
        self.planted_date = data['planted_date']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user = None
    
    @classmethod
    def add_arbortrary(cls,data):
        query = """INSERT INTO arbortrary (species,location,reason,planted_date,created_at,updated_at,user_id)
                VALUES (%(species)s,%(location)s,%(reason)s,NOW(),NOW(),NOW(),%(user_id)s);"""
        return connectToMySQL(cls.db_name).query_db(query,data)
    
    @classmethod
    def get_all(cls):
        query = """SELECT * FROM arbortrary JOIN users on arbortrary.user_id = users.id;"""
        results = connectToMySQL(cls.db_name).query_db(query)
        arbortraries = []
        for row in results:
            this_arbortrary = cls(row)
            user_data = {
                "id": row['users.id'],
                "first_name": row['first_name'],
                "last_name": row['last_name'],
                "email": row['email'],
                "password": "",
                "created_at": row['users.created_at'],
                "updated_at": row['users.updated_at']
            }
            this_arbortrary.user = user.User(user_data)
            arbortraries.append(this_arbortrary)
        return arbortraries
    
    @classmethod
    def get_one_by_id(cls,data):
        query = """SELECT * FROM arbortrary JOIN users on arbortrary.user_id = users.id 
                WHERE arbortrary.id = %(id)s;"""
        results = connectToMySQL(cls.db_name).query_db(query,data)
        if not results:
            return False
        result = results[0]
        arbortrary = cls(result)
        data = {
                "id": result['users.id'],
                "first_name": result['first_name'],
                "last_name": result['last_name'],
                "email": result['email'],
                "password": "",
                "created_at": result['users.created_at'],
                "updated_at": result['users.updated_at']
        }
        arbortrary.user = user.User(data)
        return arbortrary

    @classmethod
    def update(cls,data):
        query = """UPDATE arbortrary
                SET species = %(species)s,
                location = %(location)s,
                reason = %(reason)s,
                planted_date = NOW(),
                created_at = NOW(),
                updated_at = NOW(),
                WHERE id = %(id)s;
                """
        return connectToMySQL(cls.db_name).query_db(query,data)
    
    @classmethod
    def remove(cls,data):
        query = """DELETE FROM arbortrary WHERE id = %(id)s;"""
        return connectToMySQL(cls.db_name).query_db(query,data)
    
    @staticmethod
    def validate_arbortrary(data):
        is_valid = True
        if len(data['species']) < 5:
            flash("Species must be at least 5 characters.")
            is_valid = False
        if len(data['location']) < 2:
            flash("Location must be at least 2 characters.")
            is_valid = False
        if len(data['reason']) > 50:
            flash("Reason must be less than 50 characters.")
            is_valid = False
        if data['planted_date'] == '':
            flash("Date is missing.")
            is_valid = False
        if 'planted_date' not in data:
            flash("Date planted is missing.")
            is_valid = False
        return is_valid