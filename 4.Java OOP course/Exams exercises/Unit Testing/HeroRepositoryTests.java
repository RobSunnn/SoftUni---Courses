package heroRepository;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private HeroRepository heroRepository;
    private Hero hero;
    private Hero hero1;
    private Hero hero2;

    @Before
    public void prepare() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Hero", 100);
        this.hero1 = new Hero("Heroo", 10);
        this.hero2 = new Hero("Herooo", 101);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroWhenHeroIsNull() {
        this.heroRepository.create(null);
    }

    @Test
    public void testCreateHero() {
        this.heroRepository.create(this.hero);

        assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroWhenHeroExist() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroWhenHeroIsNull() {
        this.heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroWhenHeroNameIsEmpty() {
        this.heroRepository.remove("    ");
    }

    @Test
    public void testIsHeroRemoved() {
        this.heroRepository.create(this.hero);
        assertEquals(1, heroRepository.getCount());

        boolean hero1 = this.heroRepository.remove("Hero");
        assertTrue(hero1);
        assertEquals(0, heroRepository.getCount());

    }

    @Test
    public void testGetHeroWithHighestLevel() {
        this.heroRepository.create(hero);
        this.heroRepository.create(hero1);
        this.heroRepository.create(hero2);
        assertEquals(hero2, this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHero() {
        this.heroRepository.create(hero);
        this.heroRepository.create(hero1);

        assertEquals(this.hero, this.heroRepository.getHero("Hero") );
    }

}
