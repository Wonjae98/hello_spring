package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false ) String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name) {
        return "hello " + name; //"hello spring"
    }
    //html 을 이용하여서 내려주는 것이 아닌 단순히 hello + name을 리


    //json ?
    @GetMapping("hello-api")
    @ResponseBody //객체가 오면 jsonconverter 가 동작 -> json 형태로 바꿈
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name; // private 이기 떄문에 method 를 통해서 접근

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name =name;
        }
    }
}


