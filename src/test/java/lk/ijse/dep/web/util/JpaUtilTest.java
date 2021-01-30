package lk.ijse.dep.web.util;

import org.junit.Test;

import static org.junit.Assert.*;
public class JpaUtilTest {

    @Test
    public void getEntityManagerFactory() {
        assertNotNull(JpaUtil.getEntityManagerFactory());
    }
}
