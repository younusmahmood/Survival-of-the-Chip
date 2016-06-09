package model.enemy;

public class ExplosiveMine extends MineWorld {

	public ExplosiveMine() {
		super();
	}

	@Override
	Enemy buildEnemy() {
		return new Mine(); //Returning new mine (enemy of chip)
	}

}
