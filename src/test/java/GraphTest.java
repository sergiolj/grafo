
import core.Graph;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GraphTest {
    static Graph graph;

    @BeforeAll
    void setUp() {
        graph = new Graph();
    }

    @AfterAll
    void tearDown() {
        graph = null;
    }

    @Test
    void throwIllegalArgumentExceptionWhenCreateGraphWithNegativeSizeOrZero() {
        assertThrows(IllegalArgumentException.class, () -> new Graph(-1));
    }
    @Test
    void throwIllegalArgumentExceptionWhenCreateGraphWithZeroSize() {
        assertThrows(IllegalArgumentException.class, () -> new Graph(0));
    }
    @Test
    void throwMsgIfIllegalArgumentExceptionOccurred() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Graph(0));
        assertEquals("The maximum number of vertices must be greater than 0", exception.getMessage());
    }

    @Test
    void testToStringWhenGraphIsEmpty() {
        assertEquals("[]", graph.toString());
    }

    @Test
    void testToStringWhenGraphIsNotEmpty() {
        graph.addVertex("RS");
        graph.addVertex("BH");
        graph.addVertex("SP");
        assertEquals("[RS, BH, SP]", graph.toString());
    }

    @Test
    void testAddVertexWhenGraphReachMaximumSize() {
        Graph graphMax = new Graph(2);
        graphMax.addVertex("RS");
        graphMax.addVertex("BH");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graphMax.addVertex("SP"));
        assertEquals("The maximum number of vertices 2 has been exceeded.", exception.getMessage());
    }

    @Test
    void testAddVertexWhenGraphDoNotReachMaximumSize() {
        Graph graphLimit = new Graph(3);
        graphLimit.addVertex("RS");
        graphLimit.addVertex("BH");
        graphLimit.addVertex("SP");
    }

    @Test
    void testVertexCount() {
        Graph graphEmpty = new Graph();
        assertEquals(0, graphEmpty.getVertexes().size());
    }

    @Test
    void testGraphAttributePrivateMaximumSize() {
        Graph graphAtributePrivate = new Graph();
        try {
            Field field = Graph.class.getDeclaredField("maximumSize"); //Inform field name from the class
            field.setAccessible(true);
            assertEquals(10, field.getInt(graphAtributePrivate)); //Inform type atribute field from object Graph.class
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testVertexCountWhenGraphReachMaximumSize() {
        Graph graphFive = new Graph(5);
        graphFive.addVertex("RS");
        graphFive.addVertex("BH");
        graphFive.addVertex("BA");
        graphFive.addVertex("RJ");
        graphFive.addVertex("SC");
        assertEquals(5, graphFive.getVertexes().size());
    }

    @Test
    void testVertexCountWhenGraphIsNotEmpty() {
        Graph graphTreeVertex = new Graph();
        graphTreeVertex.addVertex("RS");
        graphTreeVertex.addVertex("BH");
        graphTreeVertex.addVertex("SP");
        assertEquals(3, graphTreeVertex.getVertexes().size());

    }

    @Test
    void testLabelsAndIndexesAreCorrectedAddVertex(){
        Graph graphLabelIndex = new Graph();
        graphLabelIndex.addVertex("RS");
        graphLabelIndex.addVertex("BH");
        graphLabelIndex.addVertex("SP");

        try {
            Field fieldMap = Graph.class.getDeclaredField("labesAndIndexes");
            fieldMap.setAccessible(true);
            Map<String, Integer> map = (Map<String, Integer>) fieldMap.get(graphLabelIndex);
            assertTrue(map.containsKey("RS"));
            assertEquals(0, map.get("RS"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
