package leetcode_easy;

import java.util.HashSet;

public class Question_929 {

    public int numUniqueEmails(String[] emails) {

        HashSet<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String localName = email.substring(0, email.indexOf('@'));
            localName = localName.replace(".", "");
            localName = localName.substring(0, localName.indexOf('+'));
            String domainName = email.substring(email.indexOf('@'));
            String newEmail = localName + domainName;
            emailSet.add(newEmail);
        }

        return emailSet.size();
    }

    public int numUniqueEmails2(String[] emails) {

        HashSet<String> emailSet = new HashSet<>();
        for (String email : emails) {

            boolean isLocalName = true;
            boolean isSkipToMouse = false;
            StringBuilder sb = new StringBuilder();
            for (char c : email.toCharArray()) {
                if (c == '.') {
                    if (isLocalName) {
                        continue;
                    }
                }

                if (c == '+') {
                    isSkipToMouse = true;
                    continue;
                }

                if (c == '@') {
                    isSkipToMouse = false;
                    isLocalName = false;
                    sb.append(c);
                    continue;
                }

                if (isSkipToMouse) {
                    continue;
                }

                sb.append(c);
            }
            //System.out.println("email:" + sb.toString());
            emailSet.add(sb.toString());
        }

        return emailSet.size();
    }

    public void solve() {

        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        System.out.println("count:" + numUniqueEmails2(emails));

    }

}
