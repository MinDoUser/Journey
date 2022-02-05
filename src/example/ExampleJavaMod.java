package example;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
// Well, Mindustry itself does not accept any other main class. It just throws a 'NoClassFoundException'
public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Welcome!");
                dialog.cont.add("behold").row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }
    public void welcomeDialog(){
   		BaseDialog dialog = new BaseDialog("Welcome");
		dialog.closeOnBack();
		dialog.cont.pane(inner -> {
			inner.pane(table -> {
				table.pane(p -> {
					p.add("[green]<< WELCOME >>", Styles.techLabel).row();
				}).fillY().growX().row();
				table.add("").row();
			}).growX().center().row();
			
			inner.table(table -> {
				table.table(t -> {
          t.add("Welcome to[stat]Journey[white], a Mod by [cyan]lol02[].\n\nMy advice is to not use OP Mods when playing campaign. \n This will reduce your game experience.").row();
					t.button("Let's go!", dialog::hide).size(150f, 100f);
				}).grow();
			}).fill();
		}).grow();
	dialog.show();
   }

    @Override
    public void loadContent(){
    }

}
