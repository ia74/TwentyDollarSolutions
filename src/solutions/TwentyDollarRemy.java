package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarRemy {
    public static class Request {
        String ip;
        String method;
        String url;
        int status;
        public Request(String ip, String method, String url, int status) {
            this.ip = ip;
            this.method = method;
            this.url = url;
            this.status = status;
        }
        public boolean isError() {
            return status / 100 == 4 || status / 100 == 5;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("remy.dat"));
        HashMap<String, ArrayList<Request>> requestList = new HashMap<>();
        HashMap<String, Integer> urlsCount = new HashMap<>();
        ArrayList<Request> generalRequests = new ArrayList<>();
        HashSet<String> uniqIps = new HashSet<>();
        double errorRate = 0.0;
        while(scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" ");
            String ip = line[2];
            String method = line[3];
            String url = line[4];
            int status = Integer.parseInt(line[5]);
            if (!requestList.containsKey(ip)) requestList.put(ip, new ArrayList<>());
            Request rx = new Request(ip, method, url, status);
            requestList.get(ip).add(rx);
            generalRequests.add(rx);
            uniqIps.add(ip);

            if(rx.isError()) {
                errorRate++;
            }

            urlsCount.putIfAbsent(url, 0);
            urlsCount.put(url, urlsCount.get(url) + 1);
        }
        errorRate /= generalRequests.size();
        int max = 0;
        String mrip = "";
        for(ArrayList<Request> rq : requestList.values()) {
            if(max < rq.size()) {
                max = rq.size();
                mrip = rq.getFirst().ip;
            }
        }

        int maxUrl = 0;
        String maxUrlA = "";
        for(Map.Entry<String, Integer> e : urlsCount.entrySet()) {
            int noe = e.getValue();
            String urlE = e.getKey();
            if(maxUrl < noe) {
                maxUrl = noe;
                maxUrlA = urlE;
            }
        }

        System.out.println("Total requests: " + generalRequests.size());
        System.out.println("Unique IP addresses: " + uniqIps.size());
        System.out.println("Most frequent IP address: " + mrip +" (" + max+" requests)");
        System.out.printf("Error rate: %.2f%%%n", errorRate*100);
        System.out.println("Most requested URL: " + maxUrlA +" (" + maxUrl+" requests)");
    }
}
