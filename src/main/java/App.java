
import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/hero-form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form,hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero", hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero", foundHero);
            return new ModelAndView(model, "detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form", (request, restore) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad", (request, restore) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = (ArrayList<Squad>) Squad.getInstances();
            model.put("squads", squads);
            ArrayList<Hero> members = Hero.getAllInstances();
            model.put("heroes", members);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            Integer size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(squadName, size, cause);
            request.session().attribute("item", squadName);
            model.put("item", request.session().attribute("item"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        post("/new/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, power, weakness);
            request.session().attribute("item", name);
            model.put("item", request.session().attribute("item"));
            model.put("newHero", newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/member/:squadId", (request, restore) -> {
            Map<String, Object> model = new HashMap<>();
            request.session().attribute("selectedSquad", request.params("squadId"));
            model.put("selectedSquad", request.session().attribute("selectedSquad"));
            model.put("item", 1);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/new/:id", (request, restore) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params(":id"));
            Hero newMember = Hero.findById(id);
            Squad newSquad = Squad.findBySquadId(1);
            newSquad.setSquadMembers(newMember);
            model.put("item", newMember.getName());
            model.put("newHero", newSquad.getSquadName());
            return new ModelAndView(model, "success.hbs");

        }, new HandlebarsTemplateEngine());
    }
}
