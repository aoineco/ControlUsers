/*
 * JDBCSample02
 * DAOException.java
 */
 
package dao;
 
/**
 * データアクセスオブジェクト例外
 */
public class DAOException extends Exception {
    /**
     * @param str
     * @param th
     */
    public DAOException(String str, Throwable th) {
        super(str, th);
    }
}