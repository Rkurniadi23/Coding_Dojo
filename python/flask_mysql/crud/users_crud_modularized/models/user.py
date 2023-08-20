from users_crud_modularized.config.mysqlconnection import connectToMySQL

class Users:
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        # make sure to call the connectToMySQL function with the schema you are targeting.
        results = connectToMySQL('users_schema').query_db(query)
        # Create an empty list to append our instances of friends
        users = []
        # Iterate over the db results and create instances of friends with cls.
        for user in results:
            users.append(cls(user))
        return users
    
    @classmethod
    def storage(cls,data):
        query = "INSERT INTO users (id, first_name, last_name, email) VALUES (%(id)s, %(first_name)s, %(last_name)s, %(email)s);"
        results = connectToMySQL('users_schema').query_db(query,data)  
        return results

    @classmethod
    def get_one(cls,data):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        results = connectToMySQL('users_schema').query_db(query,data) 
        return cls(results[0])
    
    @classmethod
    def delete(cls,data):
        query = "DELETE FROM users WHERE id = %(id)s;"
        results = connectToMySQL('users_schema').query_db(query,data) 
        return results