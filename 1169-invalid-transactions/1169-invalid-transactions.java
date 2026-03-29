class Solution {
    public List<String> invalidTransactions(String[] transactions) {

        int n = transactions.length;
        boolean[] invalid = new boolean[n];
        Transaction[] trans = new Transaction[n];

        // Parse
        for (int i = 0; i < n; i++) {
            trans[i] = new Transaction(transactions[i]);
        }

        // Case 1: amount > 1000
        for (int i = 0; i < n; i++) {
            if (trans[i].amount > 1000) {
                invalid[i] = true;
            }
        }

        // Case 2: same name, diff city within 60 min
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (trans[i].name.equals(trans[j].name) &&
                    !trans[i].city.equals(trans[j].city) &&
                    Math.abs(trans[i].time - trans[j].time) <= 60) {

                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        // Collect results (preserves duplicates)
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                result.add(transactions[i]);
            }
        }

        return result;
    }

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String s) {
            String[] parts = s.split(",");
            name = parts[0];
            time = Integer.parseInt(parts[1]);
            amount = Integer.parseInt(parts[2]);
            city = parts[3];
        }
    }
}