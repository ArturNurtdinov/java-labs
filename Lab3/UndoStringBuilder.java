import java.util.Stack;
import java.util.function.Consumer;

public class UndoStringBuilder {
    private Stack<Consumer<StringBuilder>> stack = new Stack<>();
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
        int startIndex = sb.length();
        sb.append(b);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(char c) {
        int startIndex = sb.length();
        sb.append(c);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(char[] str) {
        int startIndex = sb.length();
        sb.append(str);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(char[] str, int offset, int len) {
        int startIndex = sb.length();
        sb.append(str, offset, len);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(double d) {
        int startIndex = sb.length();
        sb.append(d);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(float f) {
        int startIndex = sb.length();
        sb.append(f);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(int i) {
        int startIndex = sb.length();
        sb.append(i);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(long l) {
        int startIndex = sb.length();
        sb.append(l);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(Object obj) {
        int startIndex = sb.length();
        sb.append(obj);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(String str) {
        int startIndex = sb.length();
        sb.append(str);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder append(StringBuffer stringBuffer) {
        int startIndex = sb.length();
        sb.append(stringBuffer);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
        return this;
    }

    public UndoStringBuilder appendCodePoint(int codePoint) {
        int startIndex = sb.length();
        sb.append(codePoint);
        int endIndex = sb.length();
        stack.push(sb -> sb.delete(startIndex, endIndex));
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
        String deleted = sb.substring(start, end);
        sb.delete(start, end);
        stack.push(sb -> sb.insert(start, deleted));
        return this;
    }

    public UndoStringBuilder deleteCharAt(int index) {
        char deleted = sb.charAt(index);
        sb.deleteCharAt(index);
        stack.push(sb -> sb.insert(index, deleted));
        return this;
    }

    public void ensureCapacity(int minimumCapacity) {
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
        sb.insert(offset, b);
        stack.push(sb -> sb.delete(offset, b ? 4 : 5));
        return this;
    }

    public UndoStringBuilder insert(int offset, char c) {
        sb.insert(offset, c);
        stack.push(sb -> sb.delete(offset, offset + 1));
        return this;
    }

    public UndoStringBuilder insert(int offset, char[] str) {
        sb.insert(offset, str);
        stack.push(sb -> sb.delete(offset, offset + str.length));
        return this;
    }

    public UndoStringBuilder insert(int index, char[] str, int offset, int len) {
        sb.insert(index, str, offset, len);
        stack.push(sb -> sb.delete(index, index + len - offset));
        return this;
    }

    public UndoStringBuilder insert(int dstOffset, CharSequence s) {
        sb.insert(dstOffset, s);
        stack.push(sb -> sb.delete(dstOffset, dstOffset + s.length()));
        return this;
    }

    public UndoStringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        sb.insert(dstOffset, s, start, end);
        stack.push(sb -> sb.delete(dstOffset, dstOffset + end - start));
        return this;
    }

    public UndoStringBuilder insert(int offset, double d) {
        int oldLength = sb.length();
        sb.insert(offset, d);
        int newLength = sb.length();
        stack.push(sb -> sb.delete(offset, offset + newLength - oldLength));
        return this;
    }

    public UndoStringBuilder insert(int offset, float f) {
        int oldLength = sb.length();
        sb.insert(offset, f);
        int newLength = sb.length();
        stack.push(sb -> sb.delete(offset, offset + newLength - oldLength));
        return this;
    }

    public UndoStringBuilder insert(int offset, int i) {
        int oldLength = sb.length();
        sb.insert(offset, i);
        int newLength = sb.length();
        stack.push(sb -> sb.delete(offset, offset + newLength - oldLength));
        return this;
    }

    public UndoStringBuilder insert(int offset, long l) {
        int oldLength = sb.length();
        sb.insert(offset, l);
        int newLength = sb.length();
        stack.push(sb -> sb.delete(offset, offset + newLength - oldLength));
        return this;
    }

    public UndoStringBuilder insert(int offset, Object obj) {
        int oldLength = sb.length();
        sb.insert(offset, obj);
        int newLength = sb.length();
        stack.push(sb -> sb.delete(offset, offset + newLength - oldLength));
        return this;
    }

    public UndoStringBuilder insert(int offset, String str) {
        sb.insert(offset, str);
        stack.push(sb -> sb.delete(offset, offset + str.length()));
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
        String old = sb.substring(start, end);
        sb.replace(start, end, str);
        stack.push(sb -> sb.replace(start, start + str.length(), old));
        return this;
    }

    public UndoStringBuilder reverse() {
        sb.reverse();
        stack.push(StringBuilder::reverse);
        return this;
    }

    public void setCharAt(int index, char ch) {
        char old = sb.charAt(index);
        sb.setCharAt(index, ch);
        stack.push(sb -> sb.setCharAt(index, old));
    }

    public void setLength(int newLength) {
        int old = sb.length();
        sb.setLength(newLength);
        stack.push(sb -> sb.setLength(old));
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
        sb.trimToSize();
    }

    public void undo() {
        if (!stack.isEmpty()) {
            stack.pop().accept(sb);
            return;
        }
        throw new NullPointerException("No changes to undo");
    }
}
