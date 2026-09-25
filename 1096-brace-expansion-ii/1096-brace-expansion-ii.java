class Solution {
    private TreeSet<String> resultSet = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        expandExpression(expression);
        return new ArrayList<>(resultSet);
    }

    private void expandExpression(String expression) {
        int closingBraceIndex = expression.indexOf('}');

        if (closingBraceIndex == -1) {
            resultSet.add(expression);
            return;
        }

        int openingBraceIndex = expression.lastIndexOf('{', closingBraceIndex);

        String prefix = expression.substring(0, openingBraceIndex);
        String suffix = expression.substring(closingBraceIndex + 1);
        String braceContent = expression.substring(openingBraceIndex + 1, closingBraceIndex);

        for (String option : braceContent.split(",")) {
            String newExpression = prefix + option + suffix;
            expandExpression(newExpression);
        }
    }
}