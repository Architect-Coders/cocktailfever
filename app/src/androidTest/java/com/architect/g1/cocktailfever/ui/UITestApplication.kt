package com.architect.g1.cocktailfever.ui

import com.architect.g1.cocktailfever.CoctelApp


class UITestApplication : CoctelApp() {
    override fun initComponent() = DaggerUITestComponent.factory().create(this)
}
