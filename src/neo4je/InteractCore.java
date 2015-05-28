package neo4je;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class InteractCore {

	public static void main(String [] args)
	{
		GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( "graph/sample_db" );
		Node firstNode;
		Node secondNode;
		Relationship relationship;
		try ( Transaction tx = graphDb.beginTx() )
		{
		firstNode = graphDb.createNode();
		firstNode.setProperty( "message", "Hola, " );
		secondNode = graphDb.createNode();
		secondNode.setProperty( "message", "El Mundo!" );

		relationship = firstNode.createRelationshipTo( secondNode, RelTypes.KNOWS );
		relationship.setProperty( "message", "brave Neo4j " );
		 tx.success();
		}
		graphDb.shutdown(); 
		
	}
}
