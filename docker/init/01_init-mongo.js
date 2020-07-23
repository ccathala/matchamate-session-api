db.createUser(
    {
        user : "matchamate_admin",
        pwd : "azerty",
        roles : [
            {
                role : "readWrite",
                db : "matchamate_session_db"
            }
        ]
    }
)