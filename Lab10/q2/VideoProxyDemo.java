// === Q2: PROXY PATTERN (Virtual Proxy + Caching) ===

// Subject interface
interface Video {
    void loadVideo(String name);
    void playVideo();
}

// RealSubject - expensive to create
class RealVideo implements Video {
    private String name;

    public RealVideo(String name) {
        this.name = name;
        loadVideo(name); // loading happens at construction
    }

    @Override
    public void loadVideo(String name) {
        System.out.println("Loading high-resolution video from server: " + name);
        // Simulate expensive load
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        System.out.println("Video loaded: " + name);
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video: " + name);
    }
}

// Proxy - controls access, lazy loads, and caches
class VideoProxyHandler implements Video {
    private RealVideo realVideo;
    private String name;
    private static java.util.Map<String, RealVideo> cache = new java.util.HashMap<>();

    public VideoProxyHandler(String name) {
        this.name = name;
    }

    @Override
    public void loadVideo(String name) {
        // Lazy loading: only load when play is actually called
        if (!cache.containsKey(name)) {
            System.out.println("[PROXY] Cache miss. Initiating load for: " + name);
            cache.put(name, new RealVideo(name));
        } else {
            System.out.println("[PROXY] Cache hit. Reusing loaded video: " + name);
        }
        realVideo = cache.get(name);
    }

    @Override
    public void playVideo() {
        loadVideo(name); // lazy load on first play
        realVideo.playVideo();
    }
}

public class VideoProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== Video Streaming with Proxy ===\n");

        Video v1 = new VideoProxyHandler("Inception.mp4");
        Video v2 = new VideoProxyHandler("Interstellar.mp4");
        Video v3 = new VideoProxyHandler("Inception.mp4"); // same as v1 - should use cache

        System.out.println("--- Request 1: Play Inception ---");
        v1.playVideo();

        System.out.println("\n--- Request 2: Play Interstellar ---");
        v2.playVideo();

        System.out.println("\n--- Request 3: Play Inception again (should use cache) ---");
        v3.playVideo();
    }
}
