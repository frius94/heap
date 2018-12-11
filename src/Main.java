import com.sun.management.HotSpotDiagnosticMXBean;

import javax.management.MBeanServer;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println("BEFORE");

        System.out.println(Runtime.getRuntime().totalMemory() / 1000000  + "MB Total Memory");
        System.out.println(Runtime.getRuntime().maxMemory() / 1000000  + "MB Max Memory");
        System.out.println(Runtime.getRuntime().freeMemory() / 1000000  + "MB Free Memory");

        for (int i = 0; i < 10000000; i++) {
            Object o = new Object();
        }

        System.out.println();
        System.out.println("AFTER");
        System.out.println(Runtime.getRuntime().totalMemory() / 1000000  + "MB Total Memory");
        System.out.println(Runtime.getRuntime().maxMemory() / 1000000  + "MB Max Memory");
        System.out.println(Runtime.getRuntime().freeMemory() / 1000000  + "MB Free Memory");

        dumpHeap("C:\\Users\\Umut\\IdeaProjects\\heap\\src\\test.hprof", true);
    }

    public static void dumpHeap(String filePath, boolean live) throws IOException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        HotSpotDiagnosticMXBean mxBean = ManagementFactory.newPlatformMXBeanProxy(
                server, "com.sun.management:type=HotSpotDiagnostic", HotSpotDiagnosticMXBean.class);
        mxBean.dumpHeap(filePath, live);
    }
}
