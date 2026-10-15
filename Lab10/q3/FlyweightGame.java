// === Q3: FLYWEIGHT PATTERN ===
// Separates intrinsic (shared) state from extrinsic (unique) state

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface GameObjectFlyweight {
    void render(int x, int y); // x,y = extrinsic (positional) state
}

// ConcreteFlyweight - stores intrinsic (shared) state: type, texture, color
class TreeType implements GameObjectFlyweight {
    private String type;
    private String texture;
    private String color;

    public TreeType(String type, String texture, String color) {
        this.type = type;
        this.texture = texture;
        this.color = color;
        System.out.println("[FLYWEIGHT CREATED] Type=" + type + ", Texture=" + texture + ", Color=" + color);
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Rendering " + type + " [texture=" + texture + ", color=" + color + "] at (" + x + ", " + y + ")");
    }
}

// Flyweight Factory - returns existing flyweight or creates new one
class GameObjectFactory {
    private static Map<String, TreeType> flyweights = new HashMap<>();

    public static TreeType getTreeType(String type, String texture, String color) {
        String key = type + "_" + texture + "_" + color;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new TreeType(type, texture, color));
        } else {
            System.out.println("[REUSING FLYWEIGHT] " + key);
        }
        return flyweights.get(key);
    }

    public static int getFlyweightCount() {
        return flyweights.size();
    }
}

// Context - stores extrinsic state (position) and reference to flyweight
class Tree {
    private int x, y;
    private GameObjectFlyweight flyweight;

    public Tree(int x, int y, String type, String texture, String color) {
        this.x = x;
        this.y = y;
        this.flyweight = GameObjectFactory.getTreeType(type, texture, color);
    }

    public void render() {
        flyweight.render(x, y);
    }
}

public class FlyweightGame {
    public static void main(String[] args) {
        System.out.println("=== Game Environment - Flyweight Pattern ===\n");

        // Place 6 trees, only 2 unique types needed
        Tree[] forest = {
            new Tree(10, 20, "Oak",  "bark.png",  "Green"),
            new Tree(30, 50, "Pine", "pine.png",  "DarkGreen"),
            new Tree(55, 15, "Oak",  "bark.png",  "Green"),   // reuses Oak flyweight
            new Tree(70, 90, "Pine", "pine.png",  "DarkGreen"), // reuses Pine flyweight
            new Tree(12, 80, "Oak",  "bark.png",  "Green"),   // reuses Oak flyweight
            new Tree(44, 33, "Pine", "pine.png",  "DarkGreen"), // reuses Pine flyweight
        };

        System.out.println("\n--- Rendering Forest ---");
        for (Tree t : forest) {
            t.render();
        }

        System.out.println("\nTotal trees rendered : " + forest.length);
        System.out.println("Unique flyweight objects in memory: " + GameObjectFactory.getFlyweightCount());
        System.out.println("Memory saved: " + (forest.length - GameObjectFactory.getFlyweightCount()) + " objects avoided");
    }
}
