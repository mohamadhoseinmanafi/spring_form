package mhrex;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mhrex.Emp;

/*
@Controller
public class rexController {
    @RequestMapping("/empform")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response){
        String message = "welcome dear rex ";
        return new ModelAndView("addEmp","message",message);
    }
}
*/

@Controller
public class rexController{
    @RequestMapping("/empform")
    public ModelAndView showForm(){
        return new ModelAndView("addEmp","command",new Emp());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Emp emp){
        System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getDesignation());
        return new ModelAndView("redirect:/viewEmp");
    }

    @RequestMapping("/viewEmp")
    public ModelAndView veiwemp(){
        List<Emp> list = new ArrayList<Emp>();
        list.add(new Emp(1,"rex125",3500f,"s.engineer"));
        list.add(new Emp(1,"rex123",6850f,"s.designer"));
        list.add(new Emp(1,"rex737",3500f,"rexEng"));
        return new ModelAndView("viewEmp","list",list);
    }
}
