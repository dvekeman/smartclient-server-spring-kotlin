package community.isomorphic.iscserver

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SampleController {

    @GetMapping("/")
    fun user(model: Model): String {
        model["firstname"] = "K"
        return "user"
    }

}