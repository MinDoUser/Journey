package example.extend;

import arc.Core;
import arc.Events;
import mindustry.Vars;
import mindustry.content.TechTree;
import mindustry.game.EventType;
import mindustry.type.Planet;
import mindustry.type.SectorPreset;
import mindustry.ui.dialogs.*;
import mindustry.ui.Styles;
  

public class JSector extends SectorPreset {
    //private String name;
    public JSector(String name, Planet planet, int sector) {
        super(name, planet, sector);
     //this.name = name;
    }
   Events.on(SectorCaptureEvent.class, e -> {
   Log.info("Sector: "+e);
   sectorDone();
   }
   public void sectorDone(){
   		BaseDialog dialog = new BaseDialog("");
		dialog.closeOnBack();
		dialog.cont.pane(inner -> {
			inner.pane(table -> {
				table.pane(p -> {
					p.add("[green]<<WELL DONE>>", Styles.techLabel).row();
				}).fillY().growX().row();
				table.add("").row();
			}).growX().center().row();
			
			inner.table(table -> {
				table.table(t -> {
          t.add("You captured another sector on your journey!").row();
					t.button("Ok!", dialog::hide).size(150f, 100f);
				}).grow();
			}).fill();
		}).grow();
	dialog.show();
   }
  
}
