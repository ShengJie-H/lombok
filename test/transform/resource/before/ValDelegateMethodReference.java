
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;
import lombok.val;

import java.util.function.Function;

public class ValDelegateMethodReference {

	public void config() {
		val column = createColumn(Entity::getValue);
	}

	private <V> Column<Entity, V> createColumn(Function<Entity, V> func) {
		return new Column<>(func);
	}

}

class Column<T, V> {
	public Column(Function<T, V> vp) {}
}

class Entity {
	@Delegate
	private MyDelegate innerDelegate;
}

@Getter
@Setter
class MyDelegate {
	private String value;
	private Boolean aBoolean;
}