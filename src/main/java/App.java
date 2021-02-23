
import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args){
        staticFileLocation("/public");


     get("/",(request, response) -> {
         Map<String, Object> model = new HashMap<>();
         return new ModelAndView(model,"index.hbs");
     }, new HandlebarsTemplateEngine());


     get("/hero-form", (request, response) -> {
         Map<String, Object> model = new HashMap<>();
         return new ModelAndView(model, "hero-form,hbs");
     }, new HandlebarsTemplateEngine());

    get("/hero", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        ArrayList<Hero> hero = Hero.getAllInstances();
        model.put("hero",hero);
        return new ModelAndView(model, "hero.hbs");
    }, new HandlebarsTemplateEngine());

        get("/new/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form",(request, restore) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
