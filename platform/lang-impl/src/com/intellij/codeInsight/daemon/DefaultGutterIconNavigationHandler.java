package com.intellij.codeInsight.daemon;

import com.intellij.codeInsight.daemon.impl.PsiElementListNavigator;
import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Collection;

/**
* @author yole
*/
public class DefaultGutterIconNavigationHandler<T extends PsiElement> implements GutterIconNavigationHandler<T> {
  private final Collection<? extends NavigatablePsiElement> myReferences;
  private final String myTitle;

  public DefaultGutterIconNavigationHandler(Collection<? extends NavigatablePsiElement> references, String title) {
    myReferences = references;
    myTitle = title;
  }

  public Collection<? extends NavigatablePsiElement> getReferences() {
    return myReferences;
  }

  @Override
  public void navigate(MouseEvent e, T elt) {
    PsiElementListNavigator.openTargets(e,
                                        myReferences.toArray(new NavigatablePsiElement[myReferences.size()]),
                                        myTitle, null, createListCellRenderer());
  }

  protected ListCellRenderer createListCellRenderer() {
    return new DefaultPsiElementCellRenderer();
  }
}
