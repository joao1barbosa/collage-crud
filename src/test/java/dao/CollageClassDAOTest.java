package dao;

import org.junit.Test;
import org.mockito.*;
import service.CollageClassService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CollageClassDAOTest {
    @Mock
    private CollageClassDAO collageClassDAO;
    @Mock private UserClassDAO userClassDAO;
    @Mock private StudentDAO studentDAO;

    @InjectMocks private CollageClassService service;

}
