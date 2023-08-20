# import the function that will return an instance of a connection
from mysqlconnection import connectToMySQL

import dojo

class Ninjas:
    
    db_name = "dojos_and_ninjas_schema"
    
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.age = data['age']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.dojos = None
    
    @classmethod
    def add_ninja(cls,data):
        query = """INSERT INTO ninjas (first_name, last_name, age, dojo_id, created_at, updated_at) 
        VALUES (%(first_name)s, %(last_name)s, %(age)s, %(dojo_id)s, NOW(), NOW());"""
        results = connectToMySQL(cls.db_name).query_db(query,data)  
        return results

