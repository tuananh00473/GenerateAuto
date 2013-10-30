package $packageName$;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Admin
 * Date: 10/26/13
 * Time: 5:23 PM
 */
@Controller
@RequestMapping("/")
public class HelloController
{
    @RequestMapping(method = RequestMethod.GET)
    public String showIndex()
    {
        return "hello";
    }
}
