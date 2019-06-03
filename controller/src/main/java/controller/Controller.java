package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.State;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	/** The c. */
	private char c;


	/**
	 * Instantiates a new controller.
	 *
	 * @param view the view
	 * @param model the model
	 * @param id_map the id map
	 */
	public Controller(final IView view, final IModel model, int id_map) {

		this.setView(view);

		this.setModel(model);


		this.view.ReadBoard(this.model.getMap());

		this.model.getObservable().addObserver(this.view.getObserver());

		this.view.getViewframe().addKeyListener(new KeyEvent(this));
	}

	/**
	 * Sets the id map.
	 *
	 * @param id_map the new id map
	 */
	public void setIdMap(int id_map)
	{
		this.model.setIdMap(id_map);

		this.model.start();
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModel getModel()
	{
		return this.model;
	}

	/**
	 * Move.
	 *
	 * @param value the value
	 */
	public void move(int value)
	{
		this.getModel().getMap().getMobile().setLastPositionX(this.model.getMap().getMobile().getX(), this.model.getMap().getMobile().getY());
		switch(value)
		{
		case 1:
			this.getModel().getMap().getMobile().getMovement().moveUp();
			this.c='O';

			break;
		case 2:
			this.getModel().getMap().getMobile().getMovement().moveDown();
			this.c='L';

			break;
		case 3:
			this.getModel().getMap().getMobile().getMovement().moveLeft();
			this.c='K';

			break;
		case 4:
			this.getModel().getMap().getMobile().getMovement().moveRight();
			this.c='M';

			break;

		}
		this.getModel().getMap().getMobile().GugusForm(c);
		this.model.play();


	if(this.model.getMap().getMobile().getState()==State.Dead)
	{
		this.view.frame(0);
	}
	else if(this.model.getMap().getMobile().getState()==State.Finish)
	{
		this.view.frame(1);
	}
	}}
