package class_design.interface_design;

/**
 * Marker interfaces are not contracts per se but somewhat
 * useful technique to “attach” or “tie” some particular trait
 * to the class. For example, with respect to Cloneable, the
 * class is marked as being available for cloning however the
 * way it should or could be done is not a part of the interface.
 * Another very well-known and widely used example of marker
 * interface is Serializable
 *
 * Serializable interface marks the class as being available for serialization
 * and deserialization, and again, it does not specify the way
 * it could or should be done.
 * The marker interfaces have their place in object-oriented design,
 * although they do not satisfy the main purpose of interface to be a contract.
 */
public interface ExampleMarkerInterface {
}
