package contracts.user

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType

Contract.make {
    description "Get a User"
    request {
        url "/users"
        method HttpMethod.GET.toString()
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
            accept(MediaType.APPLICATION_JSON_VALUE)
        }
    }
    response {
        status OK()
        body("""
         [{
              "userId":"1",
              "name":"tesSpringCloudContract",
              "phone":"08234232",
              "email":"tesduluaja@mailinator.com",
              "address":"cibunar"
         }]
       """)
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
        }
    }
}



