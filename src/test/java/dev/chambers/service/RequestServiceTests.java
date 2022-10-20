package dev.chambers.service;
import dev.chambers.dao.RequestDAO;
import dev.chambers.entities.Request;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class RequestServiceTests {
    @InjectMocks
    private static RequestService rs;
    @Mock
    private static RequestDAO requestDAO;
    private Request johnReq1;
    private Request johnReq2;
    //private Request
}
