package com.training.game;

import com.training.game.entity.*;
import com.training.game.repository.HeroRepository;
import com.training.game.service.HeroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GameApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GameApplication.class, args);

        Hero hero1 = new Hero();
        Hero hero2 = new Hero();
        hero1.setName("Yura");
        hero2.setName("Oleg");

        HeroClass mag = new HeroClass();
        mag.setName("Mag");
        hero1.setHeroClass(mag);
        hero2.setHeroClass(mag);
        mag.addHero(hero1);
        mag.addHero(hero2);


        Potion potion1 = new Potion();
        potion1.setName("BigHeath");
        Artifact artifact1 = new Artifact();
        artifact1.setName("Axe");

        Inventory inventory1 = new Inventory();
        Inventory inventory2 = new Inventory();
        inventory1.addArtifact(artifact1);
        inventory1.addPotion(potion1);
//
        artifact1.setInventory(inventory1);
        potion1.setInventory(inventory1);

        hero1.setInventory(inventory1);
        inventory1.setHero(hero1);
        hero2.setInventory(inventory2);
        inventory2.setHero(hero2);


        HeroService heroService = run.getBean(HeroService.class);
 //       heroService.save(hero1);
        System.out.println(heroService.getOne(2l).getInventory().getArtifacts().get(0).getName());

    }

}
