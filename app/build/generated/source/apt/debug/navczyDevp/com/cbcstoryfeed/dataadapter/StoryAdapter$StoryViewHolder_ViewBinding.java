// Generated code from Butter Knife. Do not modify!
package navczyDevp.com.cbcstoryfeed.dataadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import navczyDevp.com.cbcstoryfeed.R;

public class StoryAdapter$StoryViewHolder_ViewBinding implements Unbinder {
  private StoryAdapter.StoryViewHolder target;

  @UiThread
  public StoryAdapter$StoryViewHolder_ViewBinding(StoryAdapter.StoryViewHolder target,
      View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.author = Utils.findRequiredViewAsType(source, R.id.author, "field 'author'", TextView.class);
    target.pub_date = Utils.findRequiredViewAsType(source, R.id.pub_date, "field 'pub_date'", TextView.class);
    target.story_image = Utils.findRequiredViewAsType(source, R.id.image, "field 'story_image'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StoryAdapter.StoryViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.author = null;
    target.pub_date = null;
    target.story_image = null;
  }
}
