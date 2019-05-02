package leetcode_easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Question_690 {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer, Integer> impMap = new HashMap<>();
        HashMap<Integer, List<Integer>> subMap = new HashMap<>();

        int targetImportance = 0;
        LinkedList<Integer> targetSubordinates = new LinkedList<>();

        for (Employee employee : employees) {
            impMap.put(employee.id, employee.importance);
            subMap.put(employee.id, employee.subordinates);

            if (employee.id == id) {
                targetImportance = employee.importance;
                targetSubordinates.addAll(employee.subordinates);
            }
        }


        while (!targetSubordinates.isEmpty()) {
            int sid = targetSubordinates.poll();
            targetImportance += impMap.get(sid);
            targetSubordinates.addAll(subMap.get(sid));
        }

        return targetImportance;
    }

    public void solve() {
        List<Employee> employees = new ArrayList<>();
        Employee a = new Employee();
        a.id = 1;
        a.importance = 5;
        a.subordinates = new ArrayList<>();
        a.subordinates.add(2);
        a.subordinates.add(3);

        Employee b = new Employee();
        b.id = 2;
        b.importance = 3;
        b.subordinates = new ArrayList<>();
        a.subordinates.add(4);

        Employee c = new Employee();
        c.id = 3;
        c.importance = 4;
        c.subordinates = new ArrayList<>();

        Employee d = new Employee();
        d.id = 4;
        d.importance = 1;
        d.subordinates = new ArrayList<>();

        employees.add(a);
        employees.add(b);
        employees.add(c);
        employees.add(d);

        System.out.println(getImportance(employees, 1));


    }
}
