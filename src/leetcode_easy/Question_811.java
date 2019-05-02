package leetcode_easy;

import java.util.*;

public class Question_811 {

    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> cpMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] cpSplit = cpdomain.split(" ");
            int count = Integer.parseInt(cpSplit[0]);

            String domain = cpSplit[1];
            String[] subDomains = domain.split("\\.");

            for (int i = 0; i < subDomains.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < subDomains.length; j++) {
                    sb.append(subDomains[j]);
                    if (j < subDomains.length - 1) {
                        sb.append(".");
                    }
                }
                String subdomain = sb.toString();
                if (cpMap.containsKey(subdomain)) {
                    int preCount = cpMap.get(subdomain);
                    cpMap.put(subdomain, count + preCount);
                } else {
                    cpMap.put(subdomain, count);
                }
            }
        }

        List<String> result = new ArrayList<>();

        Iterator it = cpMap.entrySet().iterator();
        while (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            Map.Entry pair = (Map.Entry)it.next();
            sb.append(pair.getValue());
            sb.append(" ");
            sb.append(pair.getKey());
            result.add(sb.toString());
            it.remove(); // avoids a ConcurrentModificationException
        }

        return result;
    }


    public void solve() {
        String[] input = new String[] {
                "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
        };

        List<String> result = subdomainVisits(input);
        for (String cp : result) {
            System.out.println(cp);
        }


    }
}
