class User{
    var firstName : String  //backing field generated 
        get() = firstName
        set(value) {firstName = value}

    var lastName : String   //backing field generated
        get() = lastName
        set(value) {lastName = value}

    val name : String                         //no backing field generated
        get() = "{$firstName $lastName}"

    var address : String = "XYZ"           //^because there is no default
    //^implementation of an accessor

}