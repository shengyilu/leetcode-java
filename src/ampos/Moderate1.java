package ampos;

import java.util.*;

public class Moderate1 {

    class TableReservation {
        int checkInTime;
        int checkOutTime;
        TableReservation(String in, String out) {
            in = in.replace(":","");
            out = out.replace(":","");
            checkInTime = Integer.valueOf(in);
            checkOutTime = Integer.valueOf(out);
        }
    }

    int calculateMinTable(List<TableReservation> customerList) {
        customerList.sort(new Comparator<TableReservation>() {
            @Override
            public int compare(TableReservation o1, TableReservation o2) {
                if (o1.checkInTime > o2.checkInTime) {
                    return 1;
                } else if (o1.checkInTime < o2.checkInTime) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int tablesize = 0;
        List<TableReservation> usingTable = new ArrayList<>();
        for (TableReservation reservation : customerList) {

            TableReservation leavingUser = null;
            for (TableReservation using : usingTable) {
                if (using.checkOutTime < reservation.checkInTime) {
                    leavingUser = using;
                    break;
                }
            }
            if (leavingUser != null) {
                usingTable.remove(leavingUser);
            }
            usingTable.add(reservation);
            if (usingTable.size() > tablesize) {
                tablesize = usingTable.size();
            }
        }

        return tablesize;
    }

    int calculateMinTable2(List<TableReservation> customerList) {
        customerList.sort(new Comparator<TableReservation>() {
            @Override
            public int compare(TableReservation o1, TableReservation o2) {
                if (o1.checkInTime > o2.checkInTime) {
                    return 1;
                } else if (o1.checkInTime < o2.checkInTime) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int tablesize = 0;

        List<TableReservation> leftTables = customerList;
        while (leftTables.size() > 0) {
            int inputTablesSize = leftTables.size();
            leftTables = findNonOverlapTables(leftTables);
            tablesize = tablesize < (inputTablesSize - leftTables.size()) ? (inputTablesSize - leftTables.size()) : tablesize;
        }

        return tablesize;
    }

    private List<TableReservation> findNonOverlapTables(List<TableReservation> customerList) {
        int durationStart = -1;
        int durationEnd = -1;
        List<TableReservation> leftTables = new ArrayList<>();
        for (TableReservation reservation : customerList) {
            if (durationStart == -1) {
                durationStart = reservation.checkInTime;
                durationEnd = reservation.checkOutTime;
                continue;
            }

            if (reservation.checkInTime >= durationStart && reservation.checkInTime < durationEnd) {
                durationStart = Math.min(reservation.checkInTime, durationStart);
                durationEnd = Math.max(reservation.checkOutTime, durationEnd);
            } else {
                leftTables.add(reservation);
            }
        }
        return leftTables;
    }

    int calculateMinTable3(List<TableReservation> customerList) {
        customerList.sort(new Comparator<TableReservation>() {
            @Override
            public int compare(TableReservation o1, TableReservation o2) {
                if (o1.checkInTime > o2.checkInTime) {
                    return 1;
                } else if (o1.checkInTime < o2.checkInTime) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        Queue<TableReservation> tablesQueue = new LinkedList<>();
        for (TableReservation reservation : customerList) {
            ((LinkedList<TableReservation>) tablesQueue).add(reservation);
        }

        int minTableCount = 0;
        int tableSize = 0;
        int durationStart = -1;
        int durationEnd = -1;
        while (tablesQueue.size() > 0) {
            TableReservation reservation = ((LinkedList<TableReservation>) tablesQueue).poll();
            if (durationStart == -1) {
                durationStart = reservation.checkInTime;
                durationEnd = reservation.checkOutTime;
                tableSize++;
                continue;
            }

            if (reservation.checkInTime >= durationStart && reservation.checkInTime < durationEnd) {
                durationStart = Math.min(reservation.checkInTime, durationStart);
                durationEnd = Math.max(reservation.checkOutTime, durationEnd);
                tableSize++;
                minTableCount = minTableCount < tableSize ? tableSize : minTableCount;
            } else if (reservation.checkInTime >= durationEnd) {
                ((LinkedList<TableReservation>) tablesQueue).add(reservation);
                minTableCount = minTableCount < tableSize ? tableSize : minTableCount;

                tableSize = 0;
                durationStart = -1;
                durationEnd = -1;
            }
        }

        return minTableCount;
    }


    public void solve() {
        List<TableReservation> customerList = new ArrayList<>();
        customerList.add(new TableReservation("11:00", "12:00"));
        customerList.add(new TableReservation("11:30", "12:30"));
        customerList.add(new TableReservation("11:40", "12:40"));
        customerList.add(new TableReservation("13:00", "14:00"));
        customerList.add(new TableReservation("13:00", "14:00"));
        customerList.add(new TableReservation("13:00", "14:00"));
        customerList.add(new TableReservation("13:00", "14:00"));


        int result = calculateMinTable3(customerList);
        System.out.println(result);
    }


}
