
import core.Vertex;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VertexTests {
    private Vertex vertex;


    @BeforeAll
    void setUp() {
    }

    @Test
    void testCreateVertex() {
        assertEquals("RS", new Vertex("RS").getLabel(), "The label of the vertex should be RS");
        assertEquals("RS", new Vertex("    RS").getLabel(), "The label should be trimmed");
        assertEquals("RS", new Vertex("  RS  ").getLabel(), "The label should be trimmed");
        assertEquals("RS BH", new Vertex("RS BH").getLabel(), "The label can allow composite labels");
    }

    @Test
    void testIllegalArgumentExceptionCreateVertexWithNullLabel() {
        assertThrows(IllegalArgumentException.class, () -> new Vertex(null));
    }

    @Test
    void testIllegalArgumentExceptionCreateVertexWithBlankLabel() {
        assertThrows(IllegalArgumentException.class, () -> new Vertex(""));
    }

    @Test
    void labelToString() {
        assertEquals("RS", new Vertex("RS").toString());
    }

    @Test
    void getLabel() {
        assertEquals("RS", new Vertex("RS").getLabel());
    }

}
