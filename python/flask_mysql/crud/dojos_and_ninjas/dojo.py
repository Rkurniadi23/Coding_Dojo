# import the function that will return an instance of a connection
from mysqlconnection import connectToMySQL

import ninja

class Dojos:
    
    db_name = "dojos_and_ninjas_schema"
    
    def __init__( self , data ):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas = []
    
    @classmethod
    def get_all_dojos(cls):
        query = "SELECT * FROM dojos"
        results = connectToMySQL(cls.db_name).query_db(query)
        return results
    
    @classmethod
    def add_dojo(cls,data):
        query = """INSERT INTO dojos (name, created_at, updated_at) 
        VALUES (%(name)s, NOW(), NOW());"""
        results = connectToMySQL(cls.db_name).query_db(query,data)  
        return results
    
    @classmethod
    def get_ninjas(cls,data):
        query = """SELECT * FROM dojos LEFT JOIN ninjas ON dojos.id = ninjas.dojo_id 
        WHERE dojos.id = %(id)s;"""
        results = list(connectToMySQL(cls.db_name).query_db(query,data))
        dojo = cls(results[0])
        for row_from_db in results:
            ninja_data = {
                "id" : row_from_db["ninjas.id"],
                "first_name" : row_from_db["first_name"],
                "last_name" : row_from_db["last_name"],
                "age" : row_from_db["age"],
                "created_at" : row_from_db["ninjas.created_at"],
                "updated_at" : row_from_db["ninjas.updated_at"],
            }
        show_dojo = ninja.Ninjas(ninja_data)
        dojo.ninjas.append(show_dojo)
        return dojo