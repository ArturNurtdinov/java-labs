import java.util.Stack;

public class UndoStringBuilder {
    private Stack<String> stack = new Stack<>();
    private StringBuilder sb;

    public UndoStringBuilder() {
        sb = new StringBuilder();
    }

    public UndoStringBuilder(int capacity) {
        sb = new StringBuilder(capacity);
    }

    public UndoStringBuilder(CharSequence seq) {
        sb = new StringBuilder(seq);
    }

    public UndoStringBuilder(String str) {
        sb = new StringBuilder(str);
    }

    public UndoStringBuilder append(boolean b) {
        stack.push(sb.toString());
        sb.append(b);
        return this;
    }

    public UndoStringBuilder append(char c) {
        stack.push(sb.toString());
        sb.append(c);
        return this;
    }

    public UndoStringBuilder append(char[] str) {
        stack.push(sb.toString());
        sb.append(str);
        return this;
    }

    public UndoStringBuilder append(char[] str, int offset, int len) {
        stack.push(sb.toString());
        sb.append(str, offset, len);
        return this;
    }

    public UndoStringBuilder append(double d) {
        stack.push(sb.toString());
        sb.append(d);
        return this;
    }

    public UndoStringBuilder append(float f) {
        stack.push(sb.toString());
        sb.append(f);
        return this;
    }

    public UndoStringBuilder append(int i) {
        stack.push(sb.toString());
        sb.append(i);
        return this;
    }

    public UndoStringBuilder append(long l) {
        stack.push(sb.toString());
        sb.append(l);
        return this;
    }

    public UndoStringBuilder append(Object obj) {
        stack.push(sb.toString());
        sb.append(obj);
        return this;
    }

    public UndoStringBuilder append(String str) {
        stack.push(sb.toString());
        sb.append(str);
        return this;
    }

    public UndoStringBuilder append(StringBuffer stringBuffer) {
        stack.push(sb.toString());
        sb.append(stringBuffer);
        return this;
    }

    public UndoStringBuilder appendCodePoint(int codePoint) {
        stack.push(sb.toString());
        sb.appendCodePoint(codePoint);
        return this;
    }

    public int capacity() {
        return sb.capacity();
    }

    public char charAt(int index) {
        return sb.charAt(index);
    }

    public int codePointAt(int index) {
        return sb.codePointAt(index);
    }

    public int codePointBefore(int index) {
        return sb.codePointBefore(index);
    }

    public int copePointCount(int beginIndex, int endIndex) {
        return sb.codePointCount(beginIndex, endIndex);
    }

    public UndoStringBuilder delete(int start, int end) {
        stack.push(sb.toString());
        sb.delete(start, end);
        return this;
    }

    public UndoStringBuilder deleteCharAt(int index) {
        stack.push(sb.toString());
        sb.deleteCharAt(index);
        return this;
    }

    public void ensureCapacity(int minimumCapacity) {
        stack.push(sb.toString());
        sb.ensureCapacity(minimumCapacity);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        sb.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public int indexOf(String str) {
        return sb.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return sb.indexOf(str, fromIndex);
    }

    public UndoStringBuilder insert(int offset, boolean b) {
        stack.push(sb.toString());
        sb.insert(offset, b);
        return this;
    }

    public UndoStringBuilder insert(int offset, char c) {
        stack.push(sb.toString());
        sb.insert(offset, c);
        return this;
    }

    public UndoStringBuilder insert(int offset, char[] str) {
        stack.push(sb.toString());
        sb.insert(offset, str);
        return this;
    }

    public UndoStringBuilder insert(int index, char[] str, int offset, int len) {
        stack.push(sb.toString());
        sb.insert(index, str, offset, len);
        return this;
    }

    public UndoStringBuilder insert(int dstOffset, CharSequence s) {
        stack.push(sb.toString());
        sb.insert(dstOffset, s);
        return this;
    }

    public UndoStringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        stack.push(sb.toString());
        sb.insert(dstOffset, s, start, end);
        return this;
    }

    public UndoStringBuilder insert(int offset, double d) {
        stack.push(sb.toString());
        sb.insert(offset, d);
        return this;
    }

    public UndoStringBuilder insert(int offset, float f) {
        stack.push(sb.toString());
        sb.insert(offset, f);
        return this;
    }

    public UndoStringBuilder insert(int offset, int i) {
        stack.push(sb.toString());
        sb.insert(offset, i);
        return this;
    }

    public UndoStringBuilder insert(int offset, long l) {
        stack.push(sb.toString());
        sb.insert(offset, l);
        return this;
    }

    public UndoStringBuilder insert(int offset, Object obj) {
        stack.push(sb.toString());
        sb.insert(offset, obj);
        return this;
    }

    public UndoStringBuilder insert(int offset, String str) {
        stack.push(sb.toString());
        sb.insert(offset, str);
        return this;
    }

    public int lastIndexOf(String str) {
        return sb.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return sb.lastIndexOf(str, fromIndex);
    }

    public int length() {
        return sb.length();
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return sb.offsetByCodePoints(index, codePointOffset);
    }

    public UndoStringBuilder replace(int start, int end, String str) {
        stack.push(sb.toString());
        sb.replace(start, end, str);
        return this;
    }

    public UndoStringBuilder reverse() {
        stack.push(sb.toString());
        sb.reverse();
        return this;
    }

    public void setCharAt(int index, char ch) {
        stack.push(sb.toString());
        sb.setCharAt(index, ch);
    }

    public void setLength(int newLength) {
        stack.push(sb.toString());
        sb.setLength(newLength);
    }

    public CharSequence subSequence(int start, int end) {
        return sb.subSequence(start, end);
    }

    public String substring(int start) {
        return sb.substring(start);
    }

    public String substring(int start, int end) {
        return sb.substring(start, end);
    }

    public String toString() {
        return sb.toString();
    }

    public void trimToSize() {
        stack.push(sb.toString());
        sb.trimToSize();
    }

    public void undo() {
        if (!stack.isEmpty()) {
            sb.replace(0, sb.length(), stack.pop());
            return;
        }
        throw new NullPointerException("No changes to undo");
    }
}
