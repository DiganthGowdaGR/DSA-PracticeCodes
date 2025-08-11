class charCount {
    public int compress(char[] chars) {
        int count = 1;
        StringBuilder sb = new StringBuilder();

        sb.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) { // group ended
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(chars[i]); // start new group
                count = 1;
            } else {
                count++;
            }
        }

        // Handle last group
        if (count > 1) {
            sb.append(count);
        }

        // Copy back into chars[]
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
