package contracts.user

//import com.service.users.entity.Users
import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType

Contract.make {
    description "Create a User"
    request {
        url "/users"
        method HttpMethod.POST.toString()
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
            accept(MediaType.APPLICATION_JSON_VALUE)
        }

        body("""
          {
                "userId":"1",
                "name":"tesSpringCloudContract",
                "phone":"08234232",
                "email":"tesduluaja@mailinator.com",
                "address":"cibunar"
           }
       """)
    }
    response {
        status CREATED()
        body("""
         {
              "userId":"1",
              "name":"tesSpringCloudContract",
              "phone":"08234232",
              "email":"tesduluaja@mailinator.com",
              "address":"cibunar"
         }   
       """)
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
        }
    }
}

